package collections

fun onSaleProductsIfEmptyCollection(products: List<Product>) =
    products.filter { it.onSale } // 세일인 상품만 담아서 반환
        .map { it.name } // 제품명으로 반환
        .ifEmpty { listOf("none") } // 해당 값이 없을 경우 listOf("none") 있을 경우 그대로 반환
        .joinToString(separator = ", ") //"세탁기, 냉장고, 에어컨 ..." 식의 String으로 변환

fun onSaleProductsIfEmptyString(products: List<Product>) =
    products.filter { it.onSale }
        .joinToString(separator = ", ") { it.name }// "세탁기, 냉장고, 에어컨 ..." 형태로 이름만 나눠서 String으로 반환
        .ifEmpty { "none" } // string이 null일 경우에 none 반환

fun main() {
    val widget = Product("Oscillation Overthruster", 10.0)
    val tpsReportCoverSheet = Product(
        "TPS Report Cover Sheet",
        0.25, true
    )
    val fluxCapacitor = Product("Flux Capacitor", 29.95)
    val products = listOf(widget, tpsReportCoverSheet, fluxCapacitor)
    println(onSaleProductsIfEmptyCollection(products))

    tpsReportCoverSheet.onSale = false
    println(onSaleProductsIfEmptyCollection(products))
    println(onSaleProductsIfEmptyString(products))
}