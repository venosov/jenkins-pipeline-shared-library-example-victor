import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestHelloWorld extends BasePipelineTest {

    @Override
    @BeforeAll
    void setUp() throws Exception {
        scriptRoots += 'vars'
        super.setUp()
    }

    @Test
    void testHello() {
        String name = 'Víctor'
        def script = loadScript('vars/sayHello.groovy')
        script.call(name)
        printCallStack()
        assertJobStatusSuccess()
    }
}
