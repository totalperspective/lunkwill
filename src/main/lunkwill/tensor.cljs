(ns lunkwill.tensor
  (:require ["@tensorflow/tfjs" :as tf]
            [lunkwill.protocols :as proto]
            [hyperfiddle.rcf :refer-macros [tests]]))

(defrecord Tensor [tensor]
  proto/Tensor
  (-shape [_]
    (js->clj (.-shape tensor)))
  (-size [_]
    (js->clj (.-size tensor)))
  (-dtype [_]
    (js->clj (.-dtype tensor)))
  proto/Printable
  (-print [_]
    (.-print tensor)))

(defn tensor
  ([tensor]
   (Tensor. (tf/tensor (clj->js tensor))))
  ([tensor shape]
   (let [args (map clj->js [tensor shape])
         tens (apply tf/tensor args)]
     (Tensor. tens)))
  ([tensor shape dtype]
   (let [args (map clj->js [tensor shape dtype])
         tens (apply tf/tensor args)]
     (Tensor. tens))))

(defn shape [tensor]
  (proto/-shape tensor))

(defn size [tensor]
  (proto/-size tensor))

(defn dtype [tensor]
  (proto/-dtype tensor))

(tests
 (let [a (tensor [[1 2] [3 4]])]
   (size a) := 4))

(let [s [2 2]
      b (tensor [4 3 2 1] s)]
  (shape b) := [2 2])

(let [s [2 2]
      b (tensor [4 3 2 1] s "int32")]
  (dtype b) := "int32")
