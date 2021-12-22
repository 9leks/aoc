(ns aoc2021.day3
  (:require [clojure.java.io :as io]
            [clojure.string :refer [join]]))

(defn to-int
  ([x]
   (Integer/parseInt x))
  ([x rad]
   (Integer/parseInt x rad)))

;; day3-1
(with-open [rdr (io/reader "./day3/input.txt")]
  (let [lines (line-seq rdr)
        occurrences (reduce
                     (fn [acc line] (map + acc (map #(Character/digit % 10) line)))
                     (map #(Character/digit % 10) (first lines)) lines)
        gamma (map #(if (> % (/ (count lines) 2)) 1 0) occurrences)
        epsilon (map #(mod (inc %) 2) gamma)]
    (reduce * (map #(-> % join (to-int 2)) [gamma epsilon]))))


;; day3-2

(defn process
  [coll]
  (let [heads   (map first coll)]
    heads))


(process ["1001" "0110" "1001"])

;; (with-open [rdr (io/reader "./day3/input.txt")]
;;   (let [lines (doall (line-seq rdr))
;;         [oxygen co2 next] (fn [col])]
;;     0))
