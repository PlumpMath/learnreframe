(ns asimpleapp.views
    (:require [re-frame.core :as rf]
              [reagent.ratom :as r :refer-macros [reaction]]
              [asimpleapp.subs]
              [asimpleapp.events]))

;; -- Domino 5 - View Functions ----------------------------------------------
;(defn clock
;  []
;  (println "clock")
;  (let [time-color (rf/subscribe [:time-color])
;        time (rf/subscribe [:time])]
;    [:div.example-clock
;     {:style {:color @time-color}}
;     (str @time)]))

(defn clock
  []
  (println "clock")
  (let [time (rf/subscribe [:timemap])
        currenttime (:current-time @time)
        currentcolor (:time-color @time)]
    [:div.example-clock
     {:style {:color currentcolor}}
     (str currenttime)]))


(defn color-input
  []
  (println "color-input")
  [:div.color-input
   "Time color: "
   [:input {:type "text"
            :value @(rf/subscribe [:time-color])
            :on-change #(rf/dispatch [:time-color-change (-> % .-target .-value)])}]])  ;; <---

(defn main-panel
  []
  (let [name (rf/subscribe [:name])]
    [:div
     [:div "Hello from " @name]
     [clock]
     [color-input]]))
