(ns busshi.methods.social
  "busshi configuration wrapper around the shared social-publication membrane."
  (:require [etzhayyim.social.publication :as publication]))

(def config {:actor-id "busshi" :display-name "busshi"})
(def DISCLAIMER (publication/disclaimer config))

(defn draft-observation-post
  ([subject body sources]
   (draft-observation-post subject body sources ""))
  ([subject body sources author]
   (publication/draft-observation-post config subject body sources author)))

(defn build-live [& args]
  (apply publication/build-live config args))
