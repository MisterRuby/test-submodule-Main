package ruby.testsubmoduleweb

import AddClass
import TestClass
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TestSubmoduleWebApplication

fun main(args: Array<String>) {
    runApplication<TestSubmoduleWebApplication>(*args)

    TestClass().callTestClass()
    AddClass().callAddClass()
}
