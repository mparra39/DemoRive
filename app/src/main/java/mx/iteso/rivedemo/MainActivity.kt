package mx.iteso.rivedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import app.rive.runtime.kotlin.controllers.RiveFileController
import app.rive.runtime.kotlin.core.LinearAnimationInstance
import app.rive.runtime.kotlin.core.PlayableInstance
import app.rive.runtime.kotlin.core.Rive
import mx.iteso.rivedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val stateMachineName = "Login Machine"

    val listener = object : RiveFileController.Listener {
        override fun notifyLoop(animation: PlayableInstance) {
            var text: String? = null
            if (animation is LinearAnimationInstance) {
                text = animation.name
            }
        }

        override fun notifyPause(animation: PlayableInstance) {
            var text: String? = null
            if (animation is LinearAnimationInstance) {
                text = animation.name
            }
        }

        override fun notifyPlay(animation: PlayableInstance) {
            var text: String? = null
            if (animation is LinearAnimationInstance) {
                text = animation.name
            }
        }

        override fun notifyStateChanged(stateMachineName: String, stateName: String) {
            // Do something
            Log.i("RiveAnimation", "$stateMachineName $stateName")
        }

        override fun notifyStop(animation: PlayableInstance) {
            var text: String? = null
            if (animation is LinearAnimationInstance) {
                text = animation.name
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                )

        //rive
        Rive.init(this)
        binding.loginCharacter.registerListener(listener)
    //Log.i("RiveAnimation", binding.loginCharacter.)

        //binding.loginCharacter.play()

        /*binding.email.setOnFocusChangeListener { view, b ->
            if (b){
                binding.loginCharacter.controller.setBooleanState(stateMachineName, "isChecking", true)
            }else{
                binding.loginCharacter.controller.setBooleanState(stateMachineName, "isChecking", false)

            }
        }

        binding.passsword.setOnFocusChangeListener { view, b ->
            if (b){
                binding.loginCharacter.controller.setBooleanState(stateMachineName, "isHandsUp", true)
            }else{
                binding.loginCharacter.controller.setBooleanState(stateMachineName, "isHandsUp", false)

            }
        }


        binding.email.addTextChangedListener(object  : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {

                try {
                    binding.loginCharacter.controller.setNumberState(stateMachineName, "numLook", p0!!.length.toFloat())
                } catch (e: Exception) {
                }
            }

        })


        binding.button.setOnClickListener {

            binding.passsword.clearFocus()

            Handler(mainLooper).postDelayed({
                if (binding.email.text!!.isNotEmpty() && binding.passsword.text!!.isNotEmpty() &&
                    ( binding.email.text.toString()=="admin@gmail.com" && binding.passsword.text.toString() == "123456")){
                    binding.loginCharacter.controller.fireState(stateMachineName, "trigSuccess");

                }else{
                    binding.loginCharacter.controller.fireState(stateMachineName, "trigFail");
                }
            }, 2000)

        }*/

    }
}