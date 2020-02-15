(ns portfolio.core
    (:require
      [reagent.core :as r]))

;; -------------------------
;; Components

(defn heading []
  [:h2 "Salutations, external reality."])

(defn navbar []
  [:nav
   [:a {:href "#"} "Me"]
   [:a {:href "#"} "Recipe Share"]
   [:a {:href "#"} "MUD"]
   [:a {:href "#"} "Ingspel"]
   ])

(defn content []
  [:<>
   [:h2 "About Me"]
   [:p "In the future, will you be able to ethically transform standpoints in your business? Change the way you do business - adopt seamless architectures. Going forward, our long-term capability will deliver value to dot-bombs. We thrive because of our competitive deliverable and mission critical driver culture."]
   [:h2 "Skills"]
   [:p "Reliably touching base about synergising clouds will make us leaders in the unparalleled milestone industry. So we can hit the ground running, we will be virtually offshoring every low hanging fruit in our space. Our executive search development lifecycle enables holistic, innovative verticals. You need to strategically invest your game changers to increase your innovation velocity."]]
  )

(defn footer []
  [:h2 "Valedictions, cruel universe."])

(defn scaffolding []
  [:<>
   [heading]
   [navbar]
   [content]
   [footer]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [scaffolding] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
