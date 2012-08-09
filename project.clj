(defproject pulp "1.0.0-SNAPSHOT"
  :description "A Jekyll-inspired static site builder in clojure" 
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [hiccup "1.0.0"]
                 [org.pegdown/pegdown "0.9.2"]]
  :keep-non-project-classes true
  :repositories {"scala" "http://scala-tools.org/repo-releases"}
  :main pulp.core)
