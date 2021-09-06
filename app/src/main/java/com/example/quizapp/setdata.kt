package com.example.quizapp

object setdata {
    const val name:String="name"
    const val score:String="score"
    fun getquestion():ArrayList<Questiondata>
    {
        var que:ArrayList<Questiondata> = arrayListOf()
        var q1=Questiondata(
            "What is the capital of india?",
        1,
            "Mumbai",
            "Delhi",
            "New Delhi",
            "Kolkata",
            3
        )
        var q2=Questiondata(
            "How may colors are their in india Flag?",
        2,
        "1",
            "2",
            "3",
            "4",
            3
        )
        var q3=Questiondata(
            "Who is knwon as God of Cricket?",
            3,
            "Mahendra singh dhoni",
            "Sachin Ramesh Tendulkar",
            "Sourav Ganguly",
            "Rahul Dravid",
            2
        )
        var q4=Questiondata(
            "Who is Prime Minister of India?",
            4,
            "Narendra Damodardas Modi",
            "Arvind Kejriwal",
            "Manmohan Singh",
            "Mulayam singh yadav",
            1
        )
        var q5=Questiondata(
            "who is knwon as the missile man of India?",
            5,
            "c.v Raman",
            "Homi j.Bhabha",
            "Satyendra Nath Bose",
            "Dr. A.P.J. Abdul kalam",
            4
        )
        que.add(q1)
        que.add(q2)
        que.add(q3)
        que.add(q4)
        que.add(q5)
        return que
    }
}