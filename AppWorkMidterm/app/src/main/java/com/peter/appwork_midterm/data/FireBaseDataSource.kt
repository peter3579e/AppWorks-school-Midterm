package com.peter.appwork_midterm.data

import android.util.Log
import com.google.common.reflect.TypeToken
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.MetadataChanges
import com.google.gson.GsonBuilder
import org.json.JSONObject
import java.sql.Timestamp
import java.util.*
import kotlin.collections.ArrayList

object FireBaseDataSource {

    private val articles = FirebaseFirestore.getInstance().collection("articles")


    var list: MutableMap<String,Any> ?= null

    var listData = ArrayList<ContentData>()


    fun addData(){


        val document = articles.document()

        val data = hashMapOf(
            "author" to hashMapOf(
                "email" to "wayne@school.appworks.tw",
                "id" to "waynechen323",
                "name" to "AKA小安老師"
            ),
            "title" to "台灣首富大洗牌！「神秘鞋王」登榜首 郭台銘掉到第6名",
            "content" to "台灣首富換人了！昨（6）日美國商業雜誌富比士（Forbes）公布了2021台灣10大首富排行榜，大家熟知的郭台銘竟掉到第6名，而第1名則由神秘的74歲「鞋王」張聰淵（Zhang Congyuan）奪得，他是華利集團的創始人，為全球第二大運動鞋製造廠，長期幫NIKE和CONVERSE等知名品牌代工。",
            "createdTime" to Calendar.getInstance(),
            "id" to document.id,
            "category" to "Beauty"

        )



        document.set(data)
            .addOnSuccessListener { Log.d("Update", "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w("Update", "Error writing document", e) }
    }

    fun readData() {

       val docRef= articles
        docRef.addSnapshotListener(MetadataChanges.INCLUDE) { snapshot, e ->
            if (e != null) {
                Log.w("Snap", "Listen failed.", e)
                return@addSnapshotListener
            }


            if (snapshot != null) {
                for (document in snapshot!!) {
                    Log.d("Snap", document.id + " => " + document.data)
                    list=document.data
                    
                    Log.d("Snap", " result of list => $list")



                   val itr = list!!.keys.iterator()
                    while (itr.hasNext()){
                        val key = itr.next()
                        val value = list!![key]
                        Log.d("Snap", " value => ${value}")
                    }





                }

            }

        }

    }
}