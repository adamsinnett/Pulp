(ns pulp.core
  "Pulp: Static Site Generator"
  (:use
    [pulp site])
  (:require
    [clojure.java.io :as io])
  (:import [java.io File])
  (:gen-class))

(defn write-page
  "Write the generated page into the destination folder"
  [page]
  (spit (:title page) (:page page)))

(defn write-site
  "Write the generated site into a destination folder"
  [site dest]
  (map write-page site))

(defn gen-site
  "Generate a static site"
  [source dest]
  (let [site (compile-site source)]
     write-site site dest))

(defn -main [source dest]
  (gen-site source dest))
