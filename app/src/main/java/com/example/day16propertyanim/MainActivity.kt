package com.example.day16propertyanim

import android.animation.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.*
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val menus :Array<ImageView> by lazy {
        arrayOf(menu1,menu2,menu3,menu4,menu5,menu6,menu7)
    }
    private var status = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        menuBtn.setOnClickListener {
//            for ((i, item) in menus.withIndex()) {
//                AnimationSet(true).apply {
//
//                    addAnimation(loadRotateAnim())
//                    addAnimation(loadTranslateAnim(i, status))
//                    duration = 1000
//                    fillAfter = true
//                    interpolator = BounceInterpolator()
//                    item.startAnimation(this)
//
//                }
//
//            }
//            status = !status
//        }
        button.setOnClickListener {
            view.animate().translationX(100f)
                .translationY(100f).scaleX(1.5f)
                .scaleY(1.5f).alpha(0.5f)
                .duration = 1000
        }
        menuBtn.setOnClickListener {
            for ((i,item)in menus.withIndex()){

                val height = if(status) (-(i+1)*(menu1.height+70).toFloat()) else 0f


                    item.animate().translationY(height).
                        rotation(360f).
                        interpolator = BounceInterpolator()


            }
            status = !status


            menu1.setOnClickListener {
                Log.v("cu","dl")
            }


//            val scaleX = ObjectAnimator.ofFloat(view, "scaleX", 0.1f,1.0f,1.2f,1.5f).apply {
//                duration = 1000
//            }
//            val scaleY = ObjectAnimator.ofFloat(view, "scaleY", 0.1f,1.0f,1.2f,1.5f).apply {
//                duration = 1000
//            }
//            AnimatorSet().apply {
//                playTogether(scaleX,scaleY)
//                start()
//            }

            /*    val holderX = PropertyValuesHolder.ofFloat("scaleX", 0.1f, 1.0f, 1.2f, 1.5f)
            val holderY = PropertyValuesHolder.ofFloat("scaleY", 0.1f, 1.0f, 1.2f, 1.5f)
            ObjectAnimator.ofPropertyValuesHolder(view,holderX,holderY).apply {
                duration = 1000
                start()
            }

            ObjectAnimator.ofFloat(view,"translationX",300f,500f).apply {
                duration = 1000
                start()
            }
*/
//
//
//
//            ValueAnimator.ofFloat(0f,100f).apply {
//                duration = 1000
//                addUpdateListener(object :ValueAnimator.AnimatorUpdateListener{
//                    override fun onAnimationUpdate(p0: ValueAnimator?) {
//                        Log.v("cu","${p0?.animatedValue}")
//                    }
//
//                })
//                start()
//            }

        }
    }
    private fun loadRotateAnim() = AnimationUtils.loadAnimation(this,R.anim.rotate_anim)
    private fun loadTranslateAnim(index : Int,status:Boolean) :TranslateAnimation{
        return if(status){
            TranslateAnimation(0f,0f,0f,
                (-((index+1)*(menu1.height+70))).toFloat()
            )
        }else{
            TranslateAnimation(0f,0f,(-((index+1)*(menu1.height+70))).toFloat(),0f

            )
        }
    }
}