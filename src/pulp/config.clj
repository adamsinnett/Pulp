(ns pulp.config
  (:import (java.io File)))

(def default
  {:title "Static Page"
   :description "Site generated with pulp
   :in "templates"
   :out "pages"})

(defn config
  "Read in a config file for the generating site"
  (try 
    (let [site-config (apply hash-map (read-string (slurp (File. "site-config.clj"))))]
      (merge default site-config))
  (catch FileNotFoundException e (default))))
