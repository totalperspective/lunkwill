(ns user
  (:require [lunkwill.tensor]
            [hyperfiddle.rcf :refer-macros [tests]]))

; wait to enable tests until after app namespaces are loaded
(hyperfiddle.rcf/enable!)

; subsequent REPL interactions will run tests

; prevent test execution during cljs hot code reload
(defn ^:dev/before-load stop [] (hyperfiddle.rcf/enable! false))
(defn ^:dev/after-load start [] (hyperfiddle.rcf/enable!))

(tests
 :enabled := :enabled)
