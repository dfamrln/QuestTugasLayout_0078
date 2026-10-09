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

@Composable
fun TugasLayout(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = colorResource(R.color.layout_background),
        bottomBar = {
            Text(
                text = stringResource(R.string.copyright),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.footer_padding)),
                color = colorResource(R.color.layout_text),
                fontSize = dimensionResource(R.dimen.text_footer_size).value.sp,
                textAlign = TextAlign.Center
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(
                    horizontal = dimensionResource(
                        R.dimen.screen_padding_horizontal
                    )
                ),
            verticalArrangement = Arrangement.spacedBy(
                dimensionResource(R.dimen.card_spacing)
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                HeaderIdentitas()
            }

            items(daftarIdentitas) { identitas ->
                KartuIdentitas(data = identitas)
            }
        }
    }
}

@Composable
private fun HeaderIdentitas() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = dimensionResource(R.dimen.header_padding_top),
                bottom = dimensionResource(R.dimen.header_padding_bottom)
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            dimensionResource(R.dimen.header_text_spacing)
        )
    ) {
        Text(
            text = stringResource(R.string.prodi),
            fontSize = dimensionResource(R.dimen.text_prodi_size).value.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.layout_text),
            textAlign = TextAlign.Center
        )

        Text(
            text = stringResource(R.string.univ),
            fontSize = dimensionResource(R.dimen.text_univ_size).value.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.layout_text),
            textAlign = TextAlign.Center
        )
    }
}

// Satu fungsi ini digunakan oleh seluruh kartu.
@Composable
fun KartuIdentitas(
    data: DataIdentitas,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(
            dimensionResource(R.dimen.card_corner_radius)
        ),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(data.warnaKartu)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(
                    min = dimensionResource(R.dimen.card_min_height)
                )
                .padding(dimensionResource(R.dimen.card_padding)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                dimensionResource(R.dimen.card_content_spacing)
            )
        ) {
            LogoIdentitas(gambar = data.gambar)

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(
                    dimensionResource(R.dimen.card_text_spacing)
                )
            ) {
                Text(
                    text = stringResource(data.nama),
                    fontSize = dimensionResource(
                        R.dimen.text_nama_size
                    ).value.sp,
                    fontFamily = data.fontNama,
                    fontWeight = data.ketebalanNama,
                    color = colorResource(R.color.text_nama)
                )

                data.telepon?.let { telepon ->
                    Text(
                        text = stringResource(telepon),
                        fontSize = dimensionResource(
                            R.dimen.text_detail_size
                        ).value.sp,
                        color = colorResource(R.color.text_telepon)
                    )
                }

                Text(
                    text = stringResource(data.alamat),
                    fontSize = dimensionResource(
                        R.dimen.text_detail_size
                    ).value.sp,
                    color = colorResource(data.warnaAlamat)
                )
            }

            LogoIdentitas(gambar = data.gambar)
        }
    }
}

@Composable
private fun LogoIdentitas(@DrawableRes gambar: Int) {
    Image(
        painter = painterResource(gambar),
        contentDescription = stringResource(R.string.deskripsi_logo),
        modifier = Modifier.size(
            dimensionResource(R.dimen.logo_size)
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun TugasLayoutPreview() {
    TugasPertemuan4Theme {
        TugasLayout()
    }
}