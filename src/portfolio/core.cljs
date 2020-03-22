(ns portfolio.core
    (:require
      [reagent.core :as r]
      [stylefy.core :as stylefy]))

;; -------------------------
;; SiteMap

(def palette
  {:off-black "#0C0816"
   :off-white "#F4EFFC"
   :lavender "#D1BEF4"
   :blue "#3B77CB"
   :purple "#362560"})

(def blue-test
  {:background-color "lavender"
   :color "grey"})

(def hud-right
  {:position :fixed
   :right 0
   :display :flex
   :flex-direction :column})

(def nav-link
  {:font-size 20
   :color (:blue palette)
   :padding "3px 20px"})
;; -------------------------
;; Components

(defn heading []
  [:h2 {:style {:color (:blue palette)}} "Catherine Stewart"])

; (defn navbar []
;   [:nav (stylefy/use-style hud-right)
;    (for [{text :title destination :page} projects]
;      [:a (stylefy/use-style nav-link {:href destination}) text])
;    ])

(defn profile []
  [:div {:style {:display :flex :justify-content :space-between}}
   [:h2 "Catherine Stewart"]
   [:div {:style {:display :flex :flex-direction :column}}
    [:a {:href "https://www.github.com/katerinjo"} "GitHub"]
    [:a {:href "https://www.linkedin.com/in/katerinjo"} "LinkedIn"]]])

(defn content []
  [:<>
   [profile]
   [:p "a language nerd breaking into tech to bridge the gap between big idealistic aspirations and a fascination with syntax, structure, and semantics"]
   [:h2 "Skills"]
   [:dl
    [:dt "Languages"]
    [:dd
     [:ul
      [:li "JavaScript " [:span {:style {:opacity 0.5}} "(strong)"]]
      [:li "Python " [:span {:style {:opacity 0.5}} "(stronger)"]]
      [:li "Clojure(Script) " [:span {:style {:opacity 0.5}} "(learning)"]]]]
    [:dt "FE"]
    [:dd
     [:ul
      [:li "HTML5"]
      [:li "React"]
      [:li "Redux"]
      [:li "Semantic UI"]
      [:li "Formik"]]]
    [:dt "Style"]
    [:dd
     [:ul
      [:li "CSS"]
      [:li "Less"]
      [:li "Sass"]]]
    [:dt "BE"]
    [:dd
     [:ul
      [:li "Node" [:span {:style {:opacity 0.5}} ".js"]]
      [:li "Express" [:span {:style {:opacity 0.5}} ".js"]]]]
    [:dt "Data"]
    [:dd
     [:ul
      [:li "SQLite"]
      [:li "Knex" [:span {:style {:opacity 0.5}} ".js"]]]]]
   [:h2 "Projects"]
   [:h3 "Recipe Share"]
   [:p "This React Native app is a platform for organizing and sharing recipe innovations."]
   [:a {:href "https://github.com/katerinjo/ingspel"} [:h3 "Ingspel"]]
   [:p "English spellings with as obvious a pronunciation as possible are generated from phonetic transcription with this TypeScript utility."]
   [:a {:href "https://github.com/katerinjo/nvim"} [:h3 "Monolog"]]
   [:p "Insert special characters and transformed text anywhere with a pop-up window."]
   [:h3 "Esperanto Uninflect"]
   [:p "This Clojure library converts Esperanto vocabulary words in the wild to dictionary form for easy translation into English."]
   [:h3 "Maui"]
   [:p "Inspired by an old legend, I generated procedural world maps via a (highly simplified) climate simulation to explore what a flat Earth might look like."]])

(defn footer []
  [:h4 "(built with ClojureScript and Reagent)"])

(defn scaffolding []
  [:<>
   ; [heading]
   ; [navbar]
   [content]
   [footer]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [scaffolding] (.getElementById js/document "app")))

(defn init! []
  (stylefy/init)
  (mount-root))
