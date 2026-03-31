public class Utility {
    public boolean validateTransportId(String transportId) {
        if (!transportId.matches("RTS[0-9]{3}[A-Z]")) {
            System.out.println("Transport id " + transportId + " is invalid");
            return false;
        }
        return true;
    }
    public GoodsTransport parseDetails(String input) {
        String[] data = input.split(":");
        String transportId = data[0];
        String transportDate = data[1];
        int transportRating = Integer.parseInt(data[2]);
        String transportType = data[3];
        if (!validateTransportId(transportId)) {
            System.out.println("Please provide a valid record");
            return null;
        }
        if (transportType.equalsIgnoreCase("BrickTransport")) {
            float brickSize = Float.parseFloat(data[4]);
            int brickQuantity = Integer.parseInt(data[5]);
            float brickPrice = Float.parseFloat(data[6]);
            return new BrickTransport(transportId, transportDate, transportRating, brickSize, brickQuantity, brickPrice);
        }
        if (transportType.equalsIgnoreCase("TimberTransport")) {
            float timberLength = Float.parseFloat(data[4]);
            float timberRadius = Float.parseFloat(data[5]);
            String timberTypeVal = data[6];
            float timberPrice = Float.parseFloat(data[7]);
            return new TimberTransport(transportId, transportDate, transportRating, timberLength, timberRadius, timberTypeVal, timberPrice);
        }
        return null;
    }
    public String findObjectType(GoodsTransport goodsTransport) {
        if (goodsTransport instanceof TimberTransport)
            return "TimberTransport";
        else if (goodsTransport instanceof BrickTransport)
            return "BrickTransport";
        return "";
    }
}