(ns edn-diff
  (:require [clojure.edn :as edn]
            [clojure.string :as string]
            [lambdaisland.deep-diff2 :as ddiff]))

(defn extract-edn [s]
  (clojure.string/replace s #"(?s)(.*--\[begin dump.*?\n)(.*)(\n--\[end dump.*)" "$2"))


(defn slurp-edn [f]
  (-> (slurp f)
      extract-edn
      edn/read-string))

(defn -main [ fn-expected fn-actual ]
  (ddiff/pretty-print
   (ddiff/diff
    (slurp-edn fn-expected) (slurp-edn fn-actual))))
