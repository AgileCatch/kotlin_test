package com.example.hotel_reservation

import java.util.Random

fun main() {
    println("호텔예약 프로그램 입니다.")
    println("[메뉴]\n1. 방 예약, 2. 예약목록 출력, 3. 예약목록 (정렬) 출력, 4. 시스템 종료, 5. 금액 입금/출금 내역 목록 출력, 6. 예약 변경/취소  ")
    var num: Int? = null
    do {
        num = readLine()!!.toInt()
        if (num in 1..6) {
            println("${num}번을 입력하셨습니다.")
            println("연결하는 중 입니다...")
        } else {
            println("1번부터 6번까지만 입력할 수 있습니다.\n다시 입력해주세요.")
        }
    } while (num !in 1..6)

    var name: String? = null
    var room: Int? = null
    when (num) {
        1 -> {
            println("\n방 예약에 연결되었습니다.\n예약자분의 성함을 입력해주세요.")
            name = readLine().toString()
            var choice1: Int? = null
            do {
                println("\n예약할 호수를 입력해주세요.(100-999)")
                room = readLine()!!.toInt()
                if (room in 100..999) {
                    println("${room}호가 맞으십니까? 맞으면 1번, 틀리면 2번을 눌러주세요.")
                    choice1 = readLine()!!.toInt()
                    while (choice1 != 1 && choice1 != 2) {
                        println("잘못된 입력입니다. 다시 입력해주세요.")
                    }

                    if (choice1 == 1) {
                        println("\n${room}호가 선택되셨습니다.\n")
                        println("체크인 날짜를 입력해주세요. 예)230721")
                        do {
                            var checkin: Int = 0
                            var checkout: Int = 0
                            checkin = readLine()!!.toInt()
                            if (checkin > 230721) {
                                println("\n체크인이 ${checkin}날짜로 선택 되었습니다.\n")

                                println("체크아웃 날짜를 입력해주세요. 예)230721")
                                checkout = readLine()!!.toInt()
                                if (checkout > checkin) {
                                    println("체크아웃이 ${checkout}날짜로 선택 되었습니다.")
                                } else if (checkout <= checkin) {
                                    println("체크아웃은 체크인 날짜보다 이후 여야합니다.\n다시 입력해주세요")
                                }

                            } else if (checkin < 230721){
                                println("체크인은 지난 날은 선택할 수 없습니다.\n다시 입력해주세요")
                            }
                        } while (checkin < 230721 || checkout <= checkin)

                        val random = Random()
                        val randomNumber = random.nextInt(30000) + 50000
                        println("\n호텔 예약비는 ${randomNumber} 원입니다. 예약 하시겠습니까? \n예약을 원하면 1번, 아니면 2번을 눌러주세요.")
                        var choice2 = readLine()!!.toInt()

                        while (choice2 != 1 && choice2 != 2) {
                            println("잘못된 입력입니다. 다시 입력해주세요.")
                        }
                        if (choice2 == 1) {
                            println("\n호텔예약이 완료 되었습니다. \n즐거운 여행되세요! 감사합니다.")
                        } else {
                            println("호텔예약 서비스를 종료하겠습니다. 감사합니다.")
                        }
                    } else {
                        println("다른 호수를 입력하시겠습니까?")
                    }
                } else {
                    println("\n올바르지않은 방 번호 입니다. 100호 부터 999호 까지만 입력할 수 있습니다.\n다시 입력해주세요.")
                }

            } while (room !in 100..999 || choice1 == 2)

        }


    }

}

