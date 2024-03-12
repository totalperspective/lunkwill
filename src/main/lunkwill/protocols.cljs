(ns lunkwill.protocols)

(defprotocol Tensor
  (-shape [tensor])
  (-size [tensor])
  (-dtype [tensor]))

(defprotocol Printable
  (-print [p]))
