package com.quen.ant.superkey.fourthqa.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// 创建一个扩展属性，用于从Context获取DataStore实例
val Context.dataStore by preferencesDataStore(name = "settings")

class UserPreferencesRepository(private val context: Context) {

    // 定义一个键
    companion object {
        val FRACTION_KEY = stringPreferencesKey("fraction")
        val LEVEL_KEY = stringPreferencesKey("level")
        val QA_POINT_KEY = stringPreferencesKey("qa_point")
        val ERROR_NUM_KEY = stringPreferencesKey("error_num")
        val RIGHT_NUM_KEY = stringPreferencesKey("right_num")
        val UUID_KEY = stringPreferencesKey("uuid")
        val BLACK_VALUE = stringPreferencesKey("black_value")
    }

    suspend fun saveFraction(num: Int) {
        context.dataStore.edit { settings ->
            settings[FRACTION_KEY] = num.toString()
        }
    }

    val fractionFlow: Flow<Int> = context.dataStore.data
        .map { preferences ->
            preferences[FRACTION_KEY]?.toInt() ?: 0
        }

    suspend fun saveLevel(level: Int) {
        context.dataStore.edit { settings ->
            settings[LEVEL_KEY] = level.toString()
        }
    }

    val levelFlow: Flow<Int> = context.dataStore.data
        .map { preferences ->
            preferences[LEVEL_KEY]?.toInt() ?: 1
        }

    suspend fun saveQaPoint(pos: Int) {
        context.dataStore.edit { settings ->
            settings[QA_POINT_KEY] = pos.toString()
        }
    }

    val qaPointFlow: Flow<Int> = context.dataStore.data
        .map { preferences ->
            preferences[QA_POINT_KEY]?.toInt() ?: 0
        }

    suspend fun saveErrorNum(num: Int) {
        context.dataStore.edit { settings ->
            settings[ERROR_NUM_KEY] = num.toString()
        }
    }

    val errorNumFlow: Flow<Int> = context.dataStore.data
        .map { preferences ->
            preferences[ERROR_NUM_KEY]?.toInt() ?: 0
        }

    suspend fun saveRightNum(num: Int) {
        context.dataStore.edit { settings ->
            settings[RIGHT_NUM_KEY] = num.toString()
        }
    }

    val rightNumFlow: Flow<Int> = context.dataStore.data
        .map { preferences ->
            preferences[RIGHT_NUM_KEY]?.toInt() ?: 0
        }

    val uuidFlow: Flow<String> = context.dataStore.data
        .map { preferences ->
            preferences[UUID_KEY] ?: ""
        }

    suspend fun saveUuid(uuid: String) {
        context.dataStore.edit { settings ->
            settings[UUID_KEY] = uuid
        }
    }

    val blackValueFlow: Flow<String> = context.dataStore.data
        .map { preferences ->
            preferences[BLACK_VALUE] ?: ""
        }

    suspend fun saveBlackValue(blackValue: String) {
        context.dataStore.edit { settings ->
            settings[BLACK_VALUE] = blackValue
        }
    }
}
