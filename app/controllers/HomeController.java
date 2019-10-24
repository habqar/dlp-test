package controllers;


import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.typesafe.config.Config;
import play.cache.SyncCacheApi;
import play.libs.ws.WSClient;
import play.libs.ws.WSResponse;
import play.mvc.Controller;
import play.mvc.Result;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    private final Config config;
    private final SyncCacheApi cache;
    private final WSClient wsClient;

    @Inject
    public HomeController(Config config, SyncCacheApi cache, WSClient wsClient) {
        this.config = config;
        this.cache = cache;
        this.wsClient = wsClient;
    }

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(views.html.index.render());
    }

    /**
     * This is where the test will be coded
     * @return Result
     */
    public CompletionStage<Result> test() throws IOException {
        CompletionStage<Result> myResult =  wsClient
                .url(config.getString("uniqueimage.url"))
                .setFollowRedirects(true)
                .get()
                .thenApply(file -> ok(file.getBodyAsStream()).as("image/jpeg"));
        cache.set("item.key", myResult, config.getInt("randomfox.cache"));
        return myResult;
    }

    /**
     * This for multipes images
     * @return
     * @throws IOException
     */
    public List<CompletionStage<Result>> testMultipes() throws IOException {
        List<CompletionStage<Result>>  completionResults = new ArrayList<>();
        return getCorrespondanteImageList(config.getString("https://picsum.photos/v2/list"))
                .thenApply(r -> {
                        Iterator<JsonNode> jelements =  r.asJson().elements();
                        List<JsonNode> jsonNodeList = new ArrayList<>();
                        jelements.forEachRemaining(jsonNodeList::add);
                                completionResults.addAll(
                                        jsonNodeList.parallelStream()
                                                    .filter(x-> x.get("id").asInt() % 2 == 0)
                                                    .map(x->{
                                                        String imageUrl = x.get("download_url").asText();
                                                        return wsClient.url(imageUrl)
                                                                .get()
                                                                .thenApply(file->ok(file.getBodyAsStream())
                                                                        .as("image/jpeg"));
                                                    }).collect(Collectors.toList()));
                        return null;
        });
    }

    public CompletionStage<WSResponse> getCorrespondanteImageList(String url){
        return wsClient.url(url)
                .setContentType("application/json")
                .get();
    }


}
