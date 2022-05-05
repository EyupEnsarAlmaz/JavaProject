public class userislemleri {
    private int barkodid;
        private String ürünadi;
        private int stokadet;
        private int fiyat;
        private String kategori;
        private String aciklama;     
        
    public userislemleri(int ID, String UrunAdi, int StokAdet, int Fiyat, String Kategori, String Aciklama){
        
            this.barkodid = ID;
            this.ürünadi = UrunAdi;
            this.stokadet = StokAdet;
            this.fiyat = Fiyat;
            this.kategori = Kategori;
            this.aciklama = Aciklama;
    }
    public int getId(){
        return barkodid;
    }
    public String getUrunadi(){
        return ürünadi;
    }
    public int getstokAdet(){
        return stokadet;
    }
    public int getfiyat(){
        return fiyat;
    }
    public String getkategorii(){
        return kategori;
    }
    public String getaciklamaa(){
        return aciklama;
    }
}
