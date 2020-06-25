(ns shadow-macro-test.ns1
  #?(:cljs (:require-macros [shadow-macro-test.ns1])))

(def t-def 42)

(defn t-fn [arg] arg)

(defmacro t-macro [a] a)

(defmacro t-macro-doc "macro with doc" [a b c d] `(str ~a ~b ~c ~d))
