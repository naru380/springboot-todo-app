# SpringBoot-TODO-Application
SpringBootの練習

## 実行環境
* Ubuntu 18.04
* OpenJDK 11.0.4
* Maven 3.6.0
* Postgresql 10.10

## 環境構築
### データベースの初期設定
```bash
su postgres -c "psql -c \"CREATE ROLE root LOGIN CREATE_DB\""
psql -c "ALTER ROLE root WITH PASSWORD 'root'"
su postgres -c "psql -c \"CREATE DATABASE ROOT OWNER ROOT\""
```
### テーブルの作成
```bash
sh set_db.sh
```
### 依存ライブラリの追加
```bash
mvn -U clean install
```
### プロジェクトの実行
```bash
mvn spring-boot:run
```

## メモ
### 雛形作成
```bash
mvn -B archetype:generate -DgroupId=com.todo -DartifactId=SpringBoot-ToDo-Application -Dversion=1.0.0-SNAPSHOT -DarchetypeArtifactId=maven-archetype-quickstart
```
