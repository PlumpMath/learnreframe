(ns asimpleapp.db)

(def default-db
  {:name "re-frame"
   :time {:current-time (js/Date.)
          :time-color "#f88"}})
