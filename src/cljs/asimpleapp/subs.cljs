(ns asimpleapp.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as rf]))

;; -- Domino 4 - Query  -------------------------------------------------------

(rf/reg-sub
 :name
 (fn [db]
   (:name db)))

(rf/reg-sub
  :time
  (fn [db _]     ;; db is current app state. 2nd unused param is query vector
    (-> db
        (:time)
        (:current-time))))

(rf/reg-sub
  :time-color
  (fn [db _]
    (-> db
        (:time)
        (:time-color))))

(rf/reg-sub
  :timemap
  (fn [db _]
    (:time db)))


