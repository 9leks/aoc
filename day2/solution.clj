(ns aoc2021.day2
  (:require [clojure.java.io :as io])
  (:require [clojure.string :refer [split]]))


;; day2-1
(with-open [rdr (io/reader "./day2/input.txt")]
  (let [lines (line-seq rdr)]
    (-> (reduce (fn [[breadth depth] line]
                  (let [[direction value] (split line #" ")
                        n (Integer. value)]
                    (case direction
                      "up" [breadth (- depth n)]
                      "down" [breadth (+ depth n)]
                      "forward" [(+ breadth n) depth])))
                [0 0] lines)
        ((fn [[breadth depth]] (* breadth depth))))))


;; day2-2
(with-open [rdr (io/reader "./day2/input.txt")]
  (let [lines (line-seq rdr)]
    (-> (reduce (fn [[breadth depth aim] line]
                  (let [[direction value] (split line #" ")
                        n (Integer. value)]
                    (case direction
                      "up" [breadth depth (- aim n)]
                      "down" [breadth depth (+ aim n)]
                      "forward" [(+ breadth n) (+ depth (* aim n)) aim])))
                [0 0 0] lines)
        ((fn [[breadth depth _]] (* breadth depth))))))
