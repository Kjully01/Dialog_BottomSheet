package br.com.dialog_bottomsheet

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.com.dialog_bottomsheet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        listener()
    }

    private fun listener() {
        binding?.btnDialog?.setOnClickListener {
            dialog()
        }

        binding?.btnDialogCustom?.setOnClickListener{
            dialogCustom()
        }

    }

    private fun dialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
        builder.setMessage("Deseja excluir registro?")
        builder.setPositiveButton("Sim", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                Toast.makeText(
                    this@MainActivity,
                    "Registro excluído com sucesso",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
        builder.setNegativeButton("Não", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                Toast.makeText(
                    this@MainActivity,
                    "Registro não foi excluído",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
        builder.setNeutralButton("Cancelar"
        ) { p0, p1 -> Unit}
        builder.create().show()
    }

    private fun dialogCustom() {
        val view : View = layoutInflater.inflate(R.layout.custom_dialog, null)
        val builder = AlertDialog.Builder(this)
        builder.setView(view)
        val alert = builder.create()

        view.findViewById<Button>(R.id.btn_dismiss).setOnClickListener {
            alert.dismiss()
        }

        view.findViewById<Button>(R.id.btn_confirm).setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                "Bem vinda ao time!!",
                Toast.LENGTH_LONG
            ).show()
            alert.dismiss()
        }

        alert.show()
    }
}