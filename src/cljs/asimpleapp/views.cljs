(ns asimpleapp.views
    (:require [re-frame.core :as rf]
              [asimpleapp.subs]
              [asimpleapp.events]))

;; -- Domino 5 - View Functions ----------------------------------------------
(defn clock
  []
  (println "clock")
  (let [time-color (rf/subscribe [:time-color])
        time (rf/subscribe [:time])]
    [:div.example-clock
     {:style {:color @time-color}}
     (str @time)]))

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
