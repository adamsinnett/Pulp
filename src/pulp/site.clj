(ns pulp.site
  "Generate a static site given a source directory of templates"
  (:require
    [clojure.java.io :as io])
  (:import [java.io File]))

(defn compile-site
  "Create a site from a given source directory."
  [source-dir]
  (map (compile-pages (filter only-template-files (get-template-files source-dir)))))

(defn compile-pages
  "Create html file from a template"
  [template-file]
  (html template-file))

(defn only-template-files
  "Determines if the file is a valid template file"
  [template-file]
  (true))

(defn get-template-files
  "Return all the file from a given directory"
  [source-dir]
  (file-seq (io/file source-dir)))
