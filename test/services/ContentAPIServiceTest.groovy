package services

import org.junit.Test
import play.Application
import play.inject.guice.GuiceApplicationBuilder
import play.test.WithApplication

import javax.inject.Inject

class ContentAPIServiceTest extends WithApplication {

    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }

    @Inject
    private ContentAPIService contentAPIService;

    @Test
    void testReadImages() {
        contentAPIService.readImages("https://picsum.photos/v2/list").forEach(System.out::println)
    }
}
