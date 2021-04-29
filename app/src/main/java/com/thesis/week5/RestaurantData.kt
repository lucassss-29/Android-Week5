package com.thesis.week5

import android.util.Log

fun getRestaurantDataSet(): List<Restaurant>{
    return listOf(
        Restaurant("Du Miên Garden Cafe - Phan Văn Trị", "7 Phan Văn Trị, P. 10",R.drawable.du_mien,false),
        Restaurant("Country House Cafe", "18C Phan Văn Trị, P. 10",R.drawable.country,false),
        Restaurant("Hẻm Spaghetti - Nguyễn Oanh", "212/22 Nguyễn Oanh, P. 17",R.drawable.hem,false),
        Restaurant("Lava Coffee - Quang Trung","61 Quang Trung, P. 10",R.drawable.lava,false),
        Restaurant("Mì Cay Naga - 224 Phạm Văn Đồng","224 Phạm Văn Đồng, P.1 ",R.drawable.shasin,false),
        Restaurant("City House Cafe - Sân Vườn Lãng Mạn","21 Huỳnh Khương An, P. 5", R.drawable.city,false),
        Restaurant("Nhi Nhi Quán - Đặc Sản Phan Rang","125/48 Lê Đức Thọ, P. 17",R.drawable.nhinhi,false),
        Restaurant("Yuri Yuri - Ẩm Thực Hàn Quốc","358 Nguyễn Văn Nghi, P. 7",R.drawable.yuri,false),
        Restaurant("Trà Sữa Gong Cha - 貢茶 - Phan Văn Trị","595 Phan Văn Trị, P. 5", R.drawable.gongcha,false),
        Restaurant("Oasis Cafe","26/14 Phạm Văn Đồng, P. 3", R.drawable.osasicoffe,false),
        Restaurant("Buzza Pizza - Emart Gò Vấp","Tầng Trệt Emart Gò Vấp - 366 Phan Văn Trị, P. 5",R.drawable.buzza,false),
        Restaurant("Dallas Cakes & Coffee - Quang Trung","6 Quang Trung, P. 10",R.drawable.dallas,false),
        Restaurant("Hot & Cold - Trà Sữa & Xiên Que - Quang Trung","804 Quang Trung",R.drawable.hold_cold,false),
        Restaurant("Papaxốt - Quang Trung","458 Quang Trung", R.drawable.papaxot,false),
        Restaurant("SaiGon Chic Cafe","82 Đường Số 27, P. 6",R.drawable.saigonchic,false),
        Restaurant("Pizza Hut - Quang Trung","283 Quang Trung",R.drawable.pizzahut,false),
        Restaurant("Bánh Mì Chảo & Món Ngon Hoa Việt - Quán Cô 3 Hậu","36 Đường Số 18, P. 8",R.drawable.banhmichao,false),
        Restaurant("Kichi Kichi Lẩu Băng Chuyền - Quang Trung","1 Quang Trung",R.drawable.kichikichi,false),
        Restaurant("The Coffee House - Quang Trung","293 Quang Trung",R.drawable.coffeehouse,false),
        Restaurant("Cánh Đồng Quán - Lẩu Nướng Tại Bàn - Dương Quảng Hàm","310/14 Dương Quảng Hàm, P. 5",R.drawable.canhdongquan,false)
    )
}
private val arrayListtemp = mutableListOf<Restaurant>()

fun addRestaurantData(res: Restaurant) {
    arrayListtemp.add(res)
}
fun RemoveRestaurantData(res: Restaurant){
    for(item in arrayListtemp){
        if(item.name.equals(res.name)){
            arrayListtemp.apply { remove(item) }
            break;
        }
    }
}
private fun <E> MutableList<E>.add(element: List<E>) {

}

fun getdataRestaurant(): List<Restaurant> {
    return arrayListtemp
}

fun setFAV(): List<Restaurant> {
    var data: List<Restaurant> = getRestaurantDataSet()
    for(item in data){
        arrayListtemp.forEach { item1 ->
            if(item.name.equals(item1.name)){
                item.fav = true
            }
        }
    }
    return data
}