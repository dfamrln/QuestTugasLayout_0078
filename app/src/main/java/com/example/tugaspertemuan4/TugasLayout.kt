package com.example.tugaspertemuan4

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.tugaspertemuan4.ui.theme.TugasPertemuan4Theme
data class DataIdentitas(
    @StringRes val nama: Int,
    @StringRes val alamat: Int,
    @ColorRes val warnaKartu: Int,
    @ColorRes val warnaAlamat: Int,
    @DrawableRes val gambar: Int,
    @StringRes val telepon: Int? = null,
    val fontNama: FontFamily = FontFamily.Default,
    val ketebalanNama: FontWeight = FontWeight.Bold
)

private val daftarIdentitas = listOf(
    DataIdentitas(
        nama = R.string.nama_bambang,
        alamat = R.string.alamat_bambang,
        warnaKartu = R.color.card_bambang,
        warnaAlamat = R.color.text_alamat_kuning,
        gambar = R.drawable.umy_logo,
        fontNama = FontFamily.Cursive,
        ketebalanNama = FontWeight.Normal
    ),
    DataIdentitas(
        nama = R.string.nama_gibran,
        alamat = R.string.alamat_gibran,
        warnaKartu = R.color.card_gibran,
        warnaAlamat = R.color.text_alamat_kuning,
        gambar = R.drawable.umy_logo,
        telepon = R.string.nomor_telepon
    ),
    DataIdentitas(
        nama = R.string.nama_zhilal,
        alamat = R.string.alamat_zhilal,
        warnaKartu = R.color.card_zhilal,
        warnaAlamat = R.color.text_alamat_putih,
        gambar = R.drawable.umy_logo,
        telepon = R.string.nomor_telepon
    ),
    DataIdentitas(
        nama = R.string.nama_ahmad,
        alamat = R.string.alamat_ahmad,
        warnaKartu = R.color.card_ahmad,
        warnaAlamat = R.color.text_alamat_putih,
        gambar = R.drawable.umy_logo,
        telepon = R.string.nomor_telepon
    )
)

