(ns busshi.methods.kotoba
  "Compatibility membrane over the shared kotoba.datom commit-DAG library."
  (:require [kotoba.datom :as datom]))

(def add datom/add)
(def tx-cid datom/tx-cid)

(defn make-tx [datoms tx-id as-of prev-cid]
  (let [tx (datom/make-tx datoms {:tx-id tx-id :as-of as-of :prev-cid prev-cid})]
    {":tx/id" (:tx/id tx)
     ":tx/as-of" (:tx/as-of tx)
     ":tx/prev" (:tx/prev tx)
     ":tx/cid" (:tx/cid tx)
     ":tx/count" (:tx/count tx)
     ":tx/datoms" (:tx/datoms tx)}))

(defn- shared-tx [tx]
  {:tx/id (get tx ":tx/id")
   :tx/as-of (get tx ":tx/as-of")
   :tx/prev (get tx ":tx/prev")
   :tx/cid (get tx ":tx/cid")
   :tx/count (get tx ":tx/count")
   :tx/datoms (get tx ":tx/datoms")})

(defn- actor-tx [tx]
  {":tx/id" (:tx/id tx)
   ":tx/as-of" (:tx/as-of tx)
   ":tx/prev" (:tx/prev tx)
   ":tx/cid" (:tx/cid tx)
   ":tx/count" (:tx/count tx)
   ":tx/datoms" (:tx/datoms tx)})

#?(:clj
   (do
     (defn append-tx [tx log-path]
       (datom/append-tx! (shared-tx tx) log-path))
     (defn read-log [log-path]
       (mapv actor-tx (datom/read-log log-path)))
     (defn head-cid [log-path]
       (datom/head-cid log-path))
     (defn verify-chain [log-path]
       (datom/verify-chain log-path))))
