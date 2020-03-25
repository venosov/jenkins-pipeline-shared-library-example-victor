import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BuildPipelineTest extends BasePipelineTest {

    @Override
    @BeforeAll
    void setUp() throws Exception {
        scriptRoots += 'vars'
        super.setUp()
        helper.registerAllowedMethod('pipeline', [Closure.class], null)
        helper.registerAllowedMethod('options', [Closure.class], null)
        helper.registerAllowedMethod('timeout', [Map.class], null)
        helper.registerAllowedMethod('timestamps', [], null)
        helper.registerAllowedMethod('agent', [Closure.class], null)
        helper.registerAllowedMethod('stages', [Closure.class], null)
        helper.registerAllowedMethod('steps', [Closure.class], null)
        helper.registerAllowedMethod('script', [Closure.class], null)
        helper.registerAllowedMethod('readMavenPom', [Map.class], null)
        binding.setVariable('none', {})
        binding.setVariable('any', {})
    }

    @Test
    void test() {
        def script = loadScript('vars/buildPipeline.groovy')
        script.call()
        printCallStack()
        assertJobStatusSuccess()
    }
}
