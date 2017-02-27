(ns asimpleapp.db)

(def default-db
  {:name "re-frame"
   :time {:current-time (js/Date.)
          :color "#f88"}})
