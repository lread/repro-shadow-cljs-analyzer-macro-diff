(ns shadow-macro-test.ana-dumper
  (:require [cljs.env :as env]
            [cljs.analyzer :as ana]
            [cljs.util :as cljs-util]))

(defmacro dump-ns
  "Debug dump analyzer's compiler env data for given namespace."
  [ ns-arg ]
  (cljs-util/debug-prn "--[begin dump ns:" ns-arg "]--")
  (cljs-util/debug-prn
   (prn-str (get-in @env/*compiler* [::ana/namespaces (symbol ns-arg)])))
  (cljs-util/debug-prn "--[end dump]--")
  ;; dummy whatever expansion
  `(println ~ns-arg))
