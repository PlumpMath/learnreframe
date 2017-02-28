(ns asimpleapp.events
    (:require [re-frame.core :as rf]
              [asimpleapp.db :as db]))

;; -- Domino 2 - Event Handlers -----------------------------------------------

(rf/reg-event-db
  :initialize-db
  (fn  [_ _]
    db/default-db))


(rf/reg-event-db                ;; usage:  (dispatch [:time-color-change 34562])
  :time-color-change            ;; dispatched when the user enters a new colour into the UI text field
  (fn [db [_ new-color-value]]  ;; -db event handlers given 2 parameters:  current application state and event (a vector)
    (assoc-in db [:time :time-color] new-color-value)))   ;; compute and return the new application state


;(rf/reg-event-db                 ;; usage:  (dispatch [:timer a-js-Date])
;  :timer                         ;; every second an event of this kind will be dispatched
;  (fn [db [_ new-time]]
;    (let [newmap {:current-time new-time
;                  :time-color "#f88"}]
;      (assoc db :time newmap))))          ;; note how the 2nd parameter is destructured to obtain the data value
;;; compute and return the new application state

(rf/reg-event-db                 ;; usage:  (dispatch [:timer a-js-Date])
  :timer                         ;; every second an event of this kind will be dispatched
  (fn [db [_ new-time]]
    (assoc-in db [:time :current-time] new-time)));; note how the 2nd parameter is destructured to obtain the data value
;; compute and return the new application state