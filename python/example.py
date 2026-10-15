"""Local-only PyJWT API migration example for the Dependabot demo."""

import jwt


DEMO_KEY = "local-demo-key-do-not-use-in-production"


def create_token(payload):
    return jwt.encode(payload, DEMO_KEY, algorithm="HS256")


def read_token(token):
    return jwt.decode(token, DEMO_KEY, algorithms=["HS256"])


if __name__ == "__main__":
    demo_token = create_token({"demo": True})
    print(read_token(demo_token))
