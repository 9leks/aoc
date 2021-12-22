(ns aoc2021.day1
  (:require [clojure.java.io :as io]))

;; day1-1
(with-open [rdr (io/reader "./day1/input.txt")]
  (let [lines (line-seq rdr)]
    (reduce (fn [acc, [past, line]]
              (let [[prev, curr] (map #(Integer. %) [past, line])]
                (cond-> acc (> curr prev) inc)))
            0 (partition 2 1 lines))))


;; day1-2
(with-open [rdr (io/reader "./day1/input.txt")]
  (let [lines (line-seq rdr)]
    (reduce (fn [acc, measurements]
              (let [groups (partition 3 1 (map #(Integer. %) measurements))
                    [prev, curr] (map (fn [group] (reduce + group)) groups)]
                (cond-> acc (> curr prev) inc)))
            0 (partition 4 1 lines))))
