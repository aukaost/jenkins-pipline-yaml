#!/usr/bin/groovy

@Grab('org.yaml:snakeyaml:1.18')
import org.yaml.snakeyaml.Yaml

def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    Yaml parser = new Yaml()
    println config.content
    return parser.load(config.content.toString())
}
