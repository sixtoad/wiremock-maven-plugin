package wiremock;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import com.github.tomakehurst.wiremock.common.SingleRootFileSource;
import com.github.tomakehurst.wiremock.standalone.CommandLineOptions;
import com.github.tomakehurst.wiremock.standalone.WireMockServerRunner;

/**
 * Goal which startup wiremock
 */
@Mojo(name = "run")
public class MyMojo extends AbstractMojo {
    
    @Parameter( property = "wiremock.port", defaultValue = "9091" )
    private String port;
    
    @Parameter( property = "wiremock.mapping", defaultValue = "target/save-mappings-files/" )
    private String mapping;
    
    
    public void execute() throws MojoExecutionException {
        getLog().info("Starting wiremock.");
        new WireMockServerRunner().run("--root-dir",mapping,"--port", port,"--verbose","--extensions", "com.opentable.extension.BodyTransformer");
        while(true) {
            
        }
    }
}
