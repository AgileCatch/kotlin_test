package com.example.hotel_reservation

fun main() {
    println("호텔예약 프로그램 입니다.")
    println("[메뉴]\n1. 방 예약, 2. 예약목록 출력, 3. 예약목록 (정렬) 출력, 4. 시스템 종료, 5. 금액 입금/출금 내역 목록 출력, 6. 예약 변경/취소  ")
    var num: Int? = null
    try {
        num = readLine()!!.toInt()
        println("${num}번을 입력하셨습니다.")
        if (num in 1..6) {
            println("연결하는 중 입니다...")
        } else {
            ("1번부터 6번까지만 입력할 수 있습니다.\n 다시 입력해주세요.")
        }
    } catch (e: NumberFormatException) {
        println("번호가 올바르지 않습니다. 다시한번 확인해주세요.")
    }

    var name: String? = null
    var room: Int? = null
    when (num) {
        1 -> {
            println("\n방 예약에 연결되었습니다.\n예약자분의 성함을 입력해주세요.")
            name = readLine().toString()
            var choice : Int?=null
            do {
                println("예약할 호수를 입력해주세요.(100-999)")
                room = readLine()!!.toInt()


                if (room in 100..999) {
                    println("${room}호가 맞으십니까? 맞으면 1번, 틀리면 2번을 눌러주세요.")
                    choice = readLine()!!.toInt()
                    while (choice != 1 && choice != 2) {
                        println("잘못된 입력입니다. 다시 입력해주세요.")
                    }

                    if (choice == 1) {
                        println("${room}호가 선택되셨습니다. /n체크인 날짜를 입력해주세요. 예)230721\n")
                       var date= readLine()!!.toInt()
                        do{
                            if (date >= 230721){

                            }else{}

                        }while (date <= 230731)
                        println("체크아웃 날짜를 입력해주세요. 예)230721\n")
                        var checkout= readLine()!!.toInt()

                    } else {
                        println("다른 호수를 입력하시겠습니까?")
                    }


                }
                else {
                    println("\n올바르지않은 방 번호 입니다. 100호 부터 999호 까지만 입력할 수 있습니다.\n다시 입력해주세요.")
                }
            }
            while (choice==2)

        }

    }

}
