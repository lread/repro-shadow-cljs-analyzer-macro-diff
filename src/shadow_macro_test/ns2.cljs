(ns shadow-macro-test.ns2
  (:require [shadow-macro-test.ns1 :include-macros true])
  (:require-macros  [shadow-macro-test.ana-dumper :refer [dump-ns]]))

(dump-ns shadow-macro-test.ns1)

(defn main []
  (println "hey"))
