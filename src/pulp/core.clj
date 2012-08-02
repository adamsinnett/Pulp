(ns pulp.core
  "Pulp: Static Site Generator"
  (:use
    [pulp site])
  (:require
    [clojure.java.io :as io])
  (:import [java.io File]))


(defn gen-site
  "Generate a static site"
  [source dest]
  (write-site 
    (compile-site source)
    dest))

(defn write-site
  "Write the generated site into a destination folder"
  [site dest]
  (map write-page site))

(defn write-page
  "Write the generated page into the destination folder"
  [page]
  (with-open [w (io/writer (:title page))]
    (spit w (:data page))))

(defn -main [source dest & args]
  (gen-site (source dest)))
  
