(ns pulp.site
  "Generate a static site given a source directory of templates"
  (:use
    [hiccup.core])
  (:require
    [clojure.java.io :as io]))

(defn directory
 "Return a java directory object"
 [source]
 (let [current-dir (io/file source)
      isDir (.isDirectory current-dir)]
      (if isDir current-dir (io/file ""))))

(defn files
 "Return all files from a directory"
 [source-dir]
 (file-seq (directory source-dir)))

(defn isTemplate
  "Return true if the file is a markdown file"
  [file]
  (filter #(re-matches #"\.md" %) file))

(defn isWebpage
  "Return true if the file is an html file"
  [file]
  (filter #(re-matches #"\.html" %) file))

(defn compile-site
  "Create a site from a given source directory."
  [source-dir]
  (doseq [file (files source-dir)]
     (if (and (.isFile file) (isWebpage file))
        (-> (read-string (slurp file))
            eval
            html))))
