package com.example.quizapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_questionactivity.*

class questionactivity : AppCompatActivity() {
    private var name:String?=null
    private var score:Int=0
  private var current_position:Int=1
    private var QuestionList:ArrayList<Questiondata>?=null
    private var selected_option:Int=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questionactivity)

        name=intent.getStringExtra(setdata.name)

        QuestionList=setdata.getquestion()
        setQuestion()
        opt1.setOnClickListener {
            selectedoptionstyle(opt1,1)

        }
        opt2.setOnClickListener {
            selectedoptionstyle(opt2,2)

        }
        opt3.setOnClickListener {
            selectedoptionstyle(opt3,3)

        }
        opt4.setOnClickListener {
            selectedoptionstyle(opt4,4)
        }
        Submit.setOnClickListener {
            if(selected_option!=0)
            {
                val question= QuestionList!![current_position-1]
                if(selected_option!=question.correctans)
                {
                    setAns(selected_option,R.drawable.wrong_option)

                }else
                {
                    score++;
                }
                setAns(question.correctans,R.drawable.coorect_option)
                if(current_position==QuestionList!!.size)
                Submit.text="FINISH"
                else

                    Submit.text="GO TO NEXT"

            }else
            {
                current_position++
                when{
                    current_position<=QuestionList!!.size->
                    {
                        setQuestion()
                    }
                    else->
                    {
                        var intent=Intent(this,MainActivity2::class.java)
                        intent.putExtra(setdata.name,name.toString())
                        intent.putExtra(setdata.score,score.toString())
                        intent.putExtra("total size",QuestionList!!.size.toString())
                        startActivity(intent)
                        finish()
                    }
                }
            }
            selected_option=0
        }

    }
    fun setAns(opt:Int,color:Int)
    {
        when(opt)
        {
            1->{
                opt1.background=ContextCompat.getDrawable(this,color)
            }
            2->{
                opt2.background=ContextCompat.getDrawable(this,color)
            }
            3->{
                opt3.background=ContextCompat.getDrawable(this,color)
            }
            4->
            {
                opt4.background=ContextCompat.getDrawable(this,color)
            }
        }
    }
    fun setQuestion()
    {
        val question= QuestionList!![current_position-1]
        setoptionstyle()
        progress_bar.progress=current_position
        progress_bar.max= QuestionList!!.size
        progress_text.text="${current_position}"+"/"+"${QuestionList!!.size}"
        que_text.text=question.question
        opt1.text=question.Optionone
        opt2.text=question.Optiontwo
        opt3.text=question.Optionthird
        opt4.text=question.Optionfour

    }
    fun setoptionstyle()
    {
        var optionlist:ArrayList<TextView> = arrayListOf()
        optionlist.add(0,opt1)
        optionlist.add(1,opt2)
        optionlist.add(2,opt3)
        optionlist.add(3,opt4)
        for(op in optionlist)
        {
            op.setTextColor(Color.parseColor("#555151"))
            op.background=ContextCompat.getDrawable(this,R.drawable.question_option)
            op.typeface= Typeface.DEFAULT
        }
    }
    fun selectedoptionstyle(view:TextView,opt:Int)
    {
        setoptionstyle()
        selected_option=opt
        view.background=ContextCompat.getDrawable(this,R.drawable.selected_question_option)
        view.typeface= Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))
    }
}