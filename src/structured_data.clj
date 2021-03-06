(ns structured-data)

(defn do-a-thing [x]
  (let [xx (+ x x)]
    (Math/pow xx xx) ))

(defn spiff [v]
  (+ (get v 0) (get v 2) ))

(defn cutify [v]
  (conj v "<3"))

(defn spiff-destructuring [v]
  (let [[w x y] v] 
    (+ w y) ))

(defn point [x y]
  [x y])

(defn rectangle [bottom-left top-right]
  [bottom-left top-right])

(defn width [rectangle]
  (let [[[x1 y1] [x2 y2]] rectangle] 
    (- x2 x1) ))

(defn height [rectangle]
  (let [[[x1 y1] [x2 y2]] rectangle] 
    (- y2 y1) ))

(defn square? [rectangle]
  (== (height rectangle) (width rectangle)))

(defn area [rectangle]
  (* (width rectangle) (height rectangle) ))

(defn contains-point? [rectangle point]
  (let [[[x1 y1] [x2 y2]] rectangle 
        [px py] point]
    (and (<= x1 px x2) (<= y1 py y2)) 
  ))

(defn contains-rectangle? [outer inner]
  (let [[[x1 y1] [x2 y2]] inner]
    (and (contains-point? outer [x1 y1]) 
      (contains-point? outer [x1 y2])
      (contains-point? outer [x2 y1])
      (contains-point? outer [x2 y2])) 
  ))

(defn title-length [book]
  (count (:title book) ))

(defn author-count [book]
  (count (:authors book) ))

(defn multiple-authors? [book]
  (> (author-count book) 1))

(defn add-author [book new-author]
  (assoc book :authors (conj (:authors book) new-author) ))

(defn alive? [author]
  (not(contains? author :death-year) ))

(defn element-lengths [collection]
  (map count collection ))

(defn second-elements [collection]
  (let [fun (fn [x] (get x 1))] 
    seq(map fun collection)))

(defn titles [books]
  (map :title books))

(defn monotonic? [a-seq]
  (cond
    (apply <= a-seq) true
    (apply >= a-seq) true
    :else false
    ))

(defn stars [n]
  (apply str (repeat n "*") ))

(defn toggle [a-set elem]
  (if (contains? a-set elem) 
    (disj a-set elem) 
    (conj a-set elem) ))

(defn contains-duplicates? [a-seq]
  (> (count a-seq) (count (set a-seq)) ))

(defn old-book->new-book [book]
  (assoc book :authors (set (:authors book)) ))

(defn has-author? [book author]
  (contains? (:authors book) author))

(defn authors [books]
  (apply clojure.set/union (map :authors books) ))

(defn all-author-names [books]
  (set (map :name (authors books)) ))

(defn author->string [author]
  (let [name (:name author)
        time (cond 
                (or (contains? author :birth-year) (contains? author :death-year)) 
                    (str " (" (:birth-year author) " - " (:death-year author) ")") 
                :else "")
    ] (str name time) ))

(defn authors->string [authors]
  (apply str (interpose ", " (map author->string authors)) ))

(defn book->string [book]
  (str (:title book) ", written by " (authors->string (:authors book)) ))

(defn books->string [books]
  ( ))

(defn books-by-author [author books]
  :-)

(defn author-by-name [name authors]
  :-)

(defn living-authors [authors]
  :-)

(defn has-a-living-author? [book]
  :-)

(defn books-by-living-authors [books]
  :-)

; %________%
