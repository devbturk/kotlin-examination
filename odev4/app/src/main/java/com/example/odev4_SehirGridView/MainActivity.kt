package com.example.odev4_SehirGridView

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.sehir.view.*

class MainActivity : AppCompatActivity() {

    var tumSehirListesis = ArrayList<Sehir>()
    var sehirAdapter:SehirAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Sehileri Yükle
        tumSehirListesis.add(Sehir("Antayla","Nufus 2,426 milyon (2019)\n Akdeniz Bölgesin de yer alır \n Antalya ilinde Akdeniz iklimi hüküm sürer",R.drawable.antalya))
        tumSehirListesis.add(Sehir("İstanbul","Nufusu 15,52 milyon \n  İstanbul’un ikliminde Akdeniz, Karadeniz, Balkan ve Anadolu iklimlerinin etkisi hissedilir.\n Marmara Bölgesinde yer alır ",R.drawable.istanbul))
        tumSehirListesis.add(Sehir("İzmir","Nufus 4,321 milyon \n İzmir ilinde Akdeniz iklimi hüküm sürer \n Ege Bölgesi'nin Ege Bölümü içerisinde yer almaktadır",R.drawable.izmir))
        tumSehirListesis.add(Sehir("Mersin","Nüfus 2010 yılı verilerine göre il nüfusu 1.647.899[1], Mersin merkez nüfusu ise 843.429[1] 'dur.\n İklimi Mersin ve çevresinde, tipik sıcak ve ılıman astropikal iklimi hakimdir",R.drawable.mersin))
        tumSehirListesis.add(Sehir("Muğla","Nüfusu: 715.328 (2000)\n Muğla' da Akdeniz iklimi etkisinde kalan kara iklimi hüküm sürmektedir.",R.drawable.mugla   ))
        tumSehirListesis.add(Sehir("Trabzon","Nüfus : 795.849 (1990)\n Trabzon nemli bir iklime sahip, olup nem oranı zaman zaman % 99' lara kadar çıkmaktadır. ",R.drawable.trabzon))
        tumSehirListesis.add(Sehir("Artvin","Nüfus: 212.833 (1990)\n İl ve çevresinde rakım farklılığından kaynaklanan ılıman, sert ve Doğu Karadeniz iklimi özelliklerine rastlanılmaktadır.",R.drawable.artvin))
        tumSehirListesis.add(Sehir("Bursa","Nüfusu: 2.439.876 (2007)\n İklimi: Bursa genellikle ılıman bir iklime sahip olmakla beraber bölgelere göre iklim farklılıkları gösterir. Güneyde Uludağ' ın sert iklimi ve bol yağışlarına karşılık, kuzeyde Marmara' nın yumuşak iklimi hüküm sürmektedir. İlde kışlar genel olarak çok yağışlı, yazlar ise kuraklığa sebep olmayacak derecede yağışlı geçer.",R.drawable.bursa))
        tumSehirListesis.add(Sehir( "Denizli", "Nüfusu: 850.029 (2000)\n İklimi: Denizli ili Ege Bölgesi' nde olmasına rağmen, Ege Bölgesi' nin iklimi tamamen görülmez. Kıyı kesiminden iç bölgelere geçit yerinde olduğundan, az da olsa iç bölgelerin karasal iklimi hissedilir. Denizli ilinde, dağlar ekseriyetle denize dik olarak uzandığından denizden gelen rüzgarlara açık bulunmaktadır. Kışlar ılık ve yağışlı geçmektedir.",R.drawable.denizli))

        tumSehirListesis.add(Sehir("Eskişehir","Nüfus: 641.057 (1990)\n Eskişehir, İç Anadolu Bölgesi'nde olduğundan karasal iklime sahiptir. Yazları sıcak ve kurak,kışları soğuk ve yağışlı geçmektedir.",R.drawable.eskisehir))

        sehirAdapter = SehirAdapter(this, tumSehirListesis)


        gvListSehir.adapter = sehirAdapter
    }

    class SehirAdapter: BaseAdapter {
        var sehirListesi = ArrayList<Sehir>()
        var context: Context?=null
        constructor(context:Context, listOfSehir:ArrayList<Sehir>):super(){
            this.context = context
            this.sehirListesi = listOfSehir
        }
        override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
            // secilen sehirler hakkında bilgi
            val sehir = this.sehirListesi[position]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            //ikinci parametrenin önemi yok
            var sehirView = inflator.inflate(R.layout.sehir, null)
            //Sehir.kt
            sehirView.ivSehirresmi.setImageResource(sehir.image!!)

            sehirView.ivSehirresmi.setOnClickListener {
                val intent = Intent(context, SehirBilgilerim::class.java)
                intent.putExtra("sehirAd", sehir.sehirAd!!)
                intent.putExtra("sehirBilgileri", sehir.sehirBilgileri!!)
                intent.putExtra("image", sehir.image!!)


                context!!.startActivity(intent)
            }

            sehirView.tvSehirName.text = sehir.sehirAd!!

            return sehirView
        }

        override fun getItem(p0: Int): Any {
            return sehirListesi[p0]

        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()

        }

        override fun getCount(): Int {
            return sehirListesi.size

        }


    }
}
