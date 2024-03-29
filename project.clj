(defproject amplify-cljs-example "0.2.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [org.clojure/clojurescript "1.10.914"
                  :exclusions [com.google.javascript/closure-compiler-unshaded
                               org.clojure/google-closure-library]]
                 [thheller/shadow-cljs "2.17.0"]
                 [reagent "1.1.0"]
                 [re-frame "1.2.0"]
                 [re-com "2.13.2"]
                 [garden "1.3.10"]
                 [net.dhleong/spade "1.1.0"]
                 [org.clojars.stumitchell/clairvoyant "0.2.1"]
                 [day8/re-frame-tracer "0.1.1-SNAPSHOT"]
                 [ns-tracker "0.4.0"]]

  :plugins [[lein-garden "0.3.0"]
            [lein-ancient "1.0.0-RC3"]]

  :min-lein-version "2.9.1"

  :jvm-opts ["-Xmx2G"]

  :source-paths ["src/clj" "src/cljs"]

  :test-paths   ["test/cljs"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"
                                    "test/js"
                                    "resources/public/css"]


  :garden {:builds [{:id           "screen"
                     :source-paths ["src/clj"]
                     :stylesheet   amplify-cljs-example.css/screen
                     :compiler     {:output-to     "resources/public/css/screen.css"
                                    :pretty-print? true}}]}

  :aliases {"dev"  ["with-profile" "dev" "run" "-m" "shadow.cljs.devtools.cli" "watch" "app"]
            "prod" ["with-profile" "prod" "run" "-m" "shadow.cljs.devtools.cli" "release" "app"]}

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "1.0.4"]
                   [day8.re-frame/re-frame-10x "1.2.2"]
                   [day8.re-frame/tracing "0.6.2"]]}

   :prod
   { :dependencies [[day8.re-frame/tracing-stubs "0.6.2"]]}
   })
