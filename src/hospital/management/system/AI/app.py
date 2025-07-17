from flask import Flask, request, jsonify
import joblib
import pandas as pd

app = Flask(__name__)

model = joblib.load('disease_model.pkl')
departments = joblib.load('departments.pkl')

@app.route('/predict', methods=['POST'])
def predict():
    data = request.get_json()
    df = pd.DataFrame([data])
    prediction = model.predict(df)[0]
    department = departments.get(prediction, "General")

    return jsonify({
        'predicted_disease': prediction,
        'recommended_department': department
    })

if __name__ == '__main__':
    app.run(debug=True)
